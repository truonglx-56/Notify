package bkav.com.app.notify.define;

/**
 * Created by truonglx on 11/10/2017.
 */
public enum TypeNotify {
		ADD_TYPING_NOTIFY("typing"),

		ADD_ACTION_NOTIFY("action"),

		ADD_APP_NOTIFY("app"),

		DELETE_NOTIFY("delete");

		private String value;

		TypeNotify(String value) {
				this.value = value;
		}

		public String getValue() {
				return value;
		}

		public static TypeNotify getType(final String type) {
				for (TypeNotify notify : TypeNotify.values()) {
						if (notify.getValue().equals(type))
								return notify;
				}
				return null;
		}
}
