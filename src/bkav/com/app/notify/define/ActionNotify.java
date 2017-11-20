package bkav.com.app.notify.define;

/**
 * Created by truonglx on 06/10/2017.
 */
public enum ActionNotify {
		DEFAULT("default"),
		LIKE("like"),
		COMMENT("comment"),
		TAG("tag"),
		REMINDER("reminder"),
		EDIT("edit");

		private String value;

		ActionNotify(String value) {
				this.value = value;
		}

		public String getValue() {
				return this.value;
		}

}
