package bkav.com.app.notify.taskqueue;

import bkav.com.app.notify.NotifyManager;
import bkav.com.app.notify.define.TypeNotify;
import bkav.com.app.notify.impl.SnwNotifyDataRequest;
import bkav.com.app.notify.impl.snwnotify.SnwActionNotify;
import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.NotifyDataResquest;
import com.bkav.snwcommon.pubsub.taskqueue.TaskQueueUtil;
import com.bkav.snwcommon.pubsub.taskqueue.object.TaskqueueObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by truonglx on 06/10/2017.
 */
public class NotifyTaskQueueRepository {


		public void sentNotifyToTaskQueue(final Notify notify, final List params) throws Exception {
				TaskqueueObject taskqueueObject = new TaskqueueObject(notify.getType().getValue(), params, notify.getNotifyDataResquest().toJson());
				TaskQueueUtil.getInstance().sendToTaskQueue(NotifyDataResquest.class.getName(), taskqueueObject);
		}

		public void sentDeleteNotifyToTaskQueue(final List<Long> ids, final List params) throws Exception {
				TaskqueueObject taskqueueObject = new TaskqueueObject(TypeNotify.DELETE_NOTIFY.getValue(), params, ids);
				TaskQueueUtil.getInstance().sendToTaskQueue(NotifyDataResquest.class.getName(), taskqueueObject);
		}

		public static void main(String[] args) {


				try {

								String type;
								type = 6 % 3 == 0 ? "edit" : "add";
								NotifyDataResquest notifyDataResquest = new SnwNotifyDataRequest.Builder()
												.setApp("sdasd")
												.setFrom(1100000125355l + 3)
												.setCreatedTime(new Date().getTime())
												.setExpire(new Date().getTime() + 30 * 24 * 60 * 1000)
												.setTitle("Demo notify")
												.setType(type)
												.setLink("https://facebook.com")
												.setObject(new String("sdasd").toString())
												.build();
								Notify no = new SnwActionNotify(notifyDataResquest);
								NotifyManager.getInstance().sendToTaskQueue(no, new ArrayList());

						return;
				} catch (Exception e) {
						e.printStackTrace();
				}
		}
}
