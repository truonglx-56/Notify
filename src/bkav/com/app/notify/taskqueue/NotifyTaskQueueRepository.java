package bkav.com.app.notify.taskqueue;

import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.NotifyData;
import com.bkav.snwcommon.pubsub.taskqueue.TaskQueueUtil;
import com.bkav.snwcommon.pubsub.taskqueue.object.TaskqueueObject;

import java.util.List;

/**
 * Created by truonglx on 06/10/2017.
 */
public class NotifyTaskQueueRepository {

		/**
		 * @param notify - data
		 * @param params - list algorithm
		 * @throws Exception
		 */
		public void sentToTaskQueue(final Notify notify, final List params) throws Exception {
				TaskqueueObject taskqueueObject = new TaskqueueObject(notify.getType().getValue(), params, notify.getNotifyData());
				TaskQueueUtil.getInstance().sendToTaskQueue(NotifyData.class.getName(), taskqueueObject);
		}
}
