package bkav.com.app.notify.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by truonglx on 25/10/2017.
 */

@XmlRootElement(name = "notify")
@XmlAccessorType(XmlAccessType.FIELD)
public class SnwNotifyFilterHandlerConfig {

		@XmlElement(name = "notify-filter")
		private List<SnwNofityFilterItem> notifyFilterUser;


		public SnwNotifyFilterHandlerConfig() {
		}

		public List<SnwNofityFilterItem> getNotifyFilterUser() {
				return notifyFilterUser;
		}
}