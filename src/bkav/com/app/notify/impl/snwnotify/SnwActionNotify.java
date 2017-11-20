package bkav.com.app.notify.impl.snwnotify;

import bkav.com.app.notify.define.TypeNotify;
import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.NotifyData;

/**
 * Created by truonglx on 11/10/2017.
 */
public class SnwActionNotify implements Notify {
		private NotifyData notifyData;

		public SnwActionNotify(NotifyData notifyData) {
				this.notifyData = notifyData;
		}

		@Override
		public TypeNotify getType() {
				return TypeNotify.ADD_ACTION_NOTIFY;
		}

		@Override
		public NotifyData getNotifyData() {
				return notifyData;
		}
}
