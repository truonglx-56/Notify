package bkav.com.app.notify.define;

/**
 * Created by truonglx on 06/10/2017.
 */
public enum ActionNotify {
		DEFAULT("default"),
		LIKE("like"),            //Đã like 1 object
		COMMENT("comment"),      //Đã comment trong 1 object
		TAG("tag"),              //Đã tag bạn vào đâu đó
		REMINDER("reminder"),    //Lời nhắc ghi nhớ
		EDIT("edit"),            //Đã sửa đổi 1 object
		ADD("add");              //Đã thêm 1 cái gì đó vào 1 object

		private String value;

		ActionNotify(String value) {
				this.value = value;
		}

		public String getValue() {
				return this.value;
		}

		public static ActionNotify getType(final String type) throws Exception {
				for (ActionNotify notify : ActionNotify.values()) {
						if (notify.getValue().equals(type))
								return notify;
				}
				throw new Exception(String.format("Invalid type: %s", type));
		}

}
