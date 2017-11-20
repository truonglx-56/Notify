
import bkav.com.app.notify.impl.NotifyAlgorithmImpl;
import bkav.com.app.notify.impl.NotifyDataImpl;
import bkav.com.app.notify.impl.snwnotify.SnwTypingNotify;
import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.NotifyAlgorithm;
import bkav.com.app.notify.service.NotifyData;
import bkav.com.app.notify.taskqueue.NotifyTaskQueueRepository;
import com.bkav.snwcommon.json.JSONFactoryUtil;
import com.bkav.snwcommon.json.JSONObject;
import com.bkav.snwcommon.objects.SnwObjectType;
import com.bkav.snwcommon.sm.shard.QueryObjectIdBuilder;
import com.bkav.snwcommon.sm.shard.ShardManager;
import com.bkav.snwserver.common.Log.Log;
import com.bkav.snwserver.common.utils.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx on 06/10/2017.
 */
public class NotifyManager {

		private static NotifyManager instance;
		private NotifyTaskQueueRepository taskQueueRepository;
		private ShardManager shardManager;
		private static final Log _log = LogFactoryUtil.getLog(NotifyManager.class);


		public synchronized static NotifyManager getInstance() {
				if (instance == null) {
						instance = new NotifyManager();
				}
				return instance;
		}

		private NotifyManager() {
				shardManager = ShardManager.getInstance();
				try {
						shardManager.startUp();
				} catch (Exception e) {
						_log.error(e.toString());
				}

				taskQueueRepository = new NotifyTaskQueueRepository();
		}

		public long getSnwNotifyId() throws Exception {
				JSONObject jsonObject = shardManager.getObjectId(new QueryObjectIdBuilder().setObject(SnwObjectType.NOTIFY.getValue(), 1));
				jsonObject = jsonObject.getJSONArray("object").getJSONObject(0);
				return Long.parseLong(jsonObject.getString("object"));
		}

		public void sendToTaskQueue(final Notify notify, final List<NotifyAlgorithm> params) throws Exception {
				taskQueueRepository.sentToTaskQueue(notify, params);
		}

		public void delete(long idNotify) throws Exception {

		}

		public static void main(String[] args) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("Hello", "halo");
				NotifyData notifyData = new NotifyDataImpl.Builder()
								.setId(1l)
								.setObject(jsonObject.toString())
								.build();
				SnwTypingNotify snwTypingNotify = new SnwTypingNotify(notifyData);
				try {
						List s = new ArrayList<NotifyAlgorithmImpl>();
						s.add(new NotifyAlgorithmImpl());
						NotifyManager.getInstance().sendToTaskQueue(snwTypingNotify, s);
				} catch (Exception e) {
						e.printStackTrace();
				}

		}

}
