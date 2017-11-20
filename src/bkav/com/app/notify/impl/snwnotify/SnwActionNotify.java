package bkav.com.app.notify.impl.snwnotify;

import bkav.com.app.notify.define.TypeNotify;
import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.NotifyDataResquest;

/**
 * Created by truonglx on 11/10/2017.
 *
 * @Tag: Thong bao theo cac loai action(comment,like,tag,....)
 */
public class SnwActionNotify implements Notify {
		private NotifyDataResquest notifyDataResquest;

		public SnwActionNotify(NotifyDataResquest notifyDataResquest) {
				this.notifyDataResquest = notifyDataResquest;
		}

		@Override
		public TypeNotify getType() {
				return TypeNotify.ADD_ACTION_NOTIFY;
		}

		public NotifyDataResquest getNotifyDataResquest() {
				return notifyDataResquest;
		}

		public void setNotifyDataResquest(NotifyDataResquest data) {
				notifyDataResquest = data;
		}
}
