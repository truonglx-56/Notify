package bkav.com.app.notify.impl.snwnotify;

import bkav.com.app.notify.define.TypeNotify;
import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.NotifyDataResquest;

/**
 * Created by truonglx on 11/10/2017.
 *
 * @Tag: Thong bao tu app cho nguoi dung
 */
public class SnwAppNotify implements Notify {
		private NotifyDataResquest notifyDataResquest;

		public SnwAppNotify(NotifyDataResquest notifyDataResquest) {
				this.notifyDataResquest = notifyDataResquest;
		}

		@Override
		public TypeNotify getType() {
				return TypeNotify.ADD_APP_NOTIFY;
		}

		public NotifyDataResquest getNotifyDataResquest() {
				return notifyDataResquest;
		}

		public void setNotifyDataResquest(NotifyDataResquest data) {
				notifyDataResquest = data;
		}
}
