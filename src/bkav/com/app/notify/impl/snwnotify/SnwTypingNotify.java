package bkav.com.app.notify.impl.snwnotify;

import bkav.com.app.notify.define.TypeNotify;
import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.NotifyDataResquest;

/**
 * Created by truonglx on 10/10/2017.
 *
 * @Tag: Doi tuong thong bao co nguoi dang go trong 1 object
 */
public class SnwTypingNotify implements Notify {
		private NotifyDataResquest notifyDataResquest;

		public SnwTypingNotify() {

		}

		@Override
		public TypeNotify getType() {
				return TypeNotify.ADD_ACTION_NOTIFY;
		}

		public NotifyDataResquest getNotifyDataResquest() {
				return notifyDataResquest;
		}

		public void setNotifyDataResquest(NotifyDataResquest data) {
				this.notifyDataResquest = data;
		}
}
