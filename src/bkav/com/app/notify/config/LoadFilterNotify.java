package bkav.com.app.notify.config;

import bkav.com.app.notify.define.ActionNotify;
import bkav.com.app.notify.filter.Filter;
import bkav.com.app.notify.filter.FilterManager;
import bkav.com.app.notify.filter.Target;
import com.bkav.snwserver.common.Log.Log;
import com.bkav.snwserver.common.utils.LogFactoryUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by truonglx on 25/10/2017.
 */
public class LoadFilterNotify {

		private static final Log _log = LogFactoryUtil.getLog(LoadFilterNotify.class);

		private static LoadFilterNotify instance;

		final private Map<ActionNotify, FilterManager> filterManagerMap;

		public static synchronized LoadFilterNotify getInstance() {
				if (instance == null) {
						instance = new LoadFilterNotify();
				}
				return instance;
		}

		public Map<ActionNotify, FilterManager> getFilterManagerMap() {
				return filterManagerMap;
		}

		public FilterManager getFilterManager(ActionNotify actionNotify) {
				return this.filterManagerMap.get(actionNotify);
		}

		private LoadFilterNotify() {
				filterManagerMap = new HashMap<>();
		}

		private SnwNotifyFilterHandlerConfig loadFilter(String configFilePath) {
				try {
						File file = new File(configFilePath);
						JAXBContext jaxbContext = JAXBContext.newInstance(SnwNotifyFilterHandlerConfig.class);
						Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
						return (SnwNotifyFilterHandlerConfig) jaxbUnmarshaller.unmarshal(file);

				} catch (JAXBException e) {
						_log.error(e);
				}

				return null;
		}

		public void initFilter(String path) {
				SnwNotifyFilterHandlerConfig snwNotifyFilterHandlerConfig = loadFilter(path);

				if (snwNotifyFilterHandlerConfig == null) {
						return;
				}

				filterManagerMap.clear();
				for (SnwNofityFilterItem item : snwNotifyFilterHandlerConfig.getNotifyFilterUser()) {
						try {
								Target target = (Target) Class.forName(item.getClassGeneral()).newInstance();
								ActionNotify actionNotify = ActionNotify.getType(item.getActionType());
								FilterManager filterManager = new FilterManager(target);

								for (SnwElementFilterNotify snwElementFilterNotify : item.getSnwElementFilterNotifies()) {
										try {
												Filter filter = (Filter) Class.forName(snwElementFilterNotify.getClassName()).newInstance();
												filterManager.addFilter(filter);
										} catch (Exception e) {
												_log.error(e);
										}
								}

								filterManagerMap.put(actionNotify, filterManager);
						} catch (Exception e) {
								_log.error(e);
						}
				}
		}

}
