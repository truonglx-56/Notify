package bkav.com.app.notify.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by truonglx on 26/10/2017.
 */
@XmlRootElement
public class SnwElementFilterNotify {
		String name;
		String clazz;

		public String getName() {
				return name;
		}

		public String getClassName() {
				return clazz;
		}

		@XmlAttribute(name = "name")
		public void setName(String name) {
				this.name = name;
		}

		@XmlAttribute(name = "class")
		public void setsClass(String clazz) {
				this.clazz = clazz;
		}
}
