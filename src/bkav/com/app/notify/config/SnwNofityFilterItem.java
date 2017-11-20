package bkav.com.app.notify.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by truonglx on 25/10/2017.
 */
@XmlRootElement
public class SnwNofityFilterItem {
		private String name;
		private String actionType;
		private String classGeneral;

		@XmlElement(name = "filter")
		private List<SnwElementFilterNotify> snwElementFilterNotifies;

		public String getActionType() {
				return actionType;
		}

		public String getFilterActionName() {
				return name;
		}

		@XmlAttribute(name = "name")
		public void setFilterActionName(String name) {
				this.name = name;
		}

		@XmlAttribute(name = "action-type")
		public void setActionType(String actionType) {
				this.actionType = actionType;
		}

		@XmlAttribute(name = "class-general")
		public void setClassGeneral(String general) {
				this.classGeneral = general;
		}

		public String getClassGeneral() {
				return classGeneral;
		}

		public List<SnwElementFilterNotify> getSnwElementFilterNotifies() {
				return snwElementFilterNotifies;
		}

}
