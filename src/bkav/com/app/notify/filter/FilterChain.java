package bkav.com.app.notify.filter;


import com.bkav.snwserver.common.Log.Log;
import com.bkav.snwserver.common.utils.LogFactoryUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by truonglx on 11/10/2017.
 */
public class FilterChain {
		private static final Log _log = LogFactoryUtil.getLog(FilterChain.class);

		private List<Filter> filterList;
		private Target target;

		public FilterChain() {
				filterList = new ArrayList<>();
		}

		public void addFilter(Filter filter) {
				filterList.add(filter);
		}

		public void execute(Object data) throws Exception {
				List<Long> list = new ArrayList<>();
				for (Filter filter : filterList) {
						try {
								list.addAll(filter.execute(data));

						} catch (Exception e) {
								_log.debug(filter.getClass().toString(), e);
						}
				}

				list = new ArrayList<>(new LinkedHashSet<>(list));
				target.execute(data, list);
		}

		public void setTarget(Target target) {
				this.target = target;
		}

}
