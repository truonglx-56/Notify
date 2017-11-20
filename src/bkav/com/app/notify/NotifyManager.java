package bkav.com.app.notify;

import bkav.com.app.notify.cache.NotifyCache;
import bkav.com.app.notify.service.Notify;
import bkav.com.app.notify.service.UserNotifications;
import bkav.com.app.notify.taskqueue.NotifyTaskQueueRepository;
import com.bkav.snwcommon.json.JSONObject;
import com.bkav.snwcommon.objects.SnwObjectType;
import com.bkav.snwcommon.sm.shard.QueryObjectIdBuilder;
import com.bkav.snwcommon.sm.shard.ShardManager;
import com.bkav.snwserver.common.Log.Log;
import com.bkav.snwserver.common.utils.LogFactoryUtil;

import java.util.List;

/**
 * Created by truonglx on 06/10/2017.
 */
public class NotifyManager {

		private static final Log _log = LogFactoryUtil.getLog(NotifyManager.class);

		final private NotifyTaskQueueRepository taskQueueRepository;
		final private NotifyCache notifyCache;
		final private ShardManager shardManager;

		private static NotifyManager instance;

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
				notifyCache = new NotifyCache();
		}

		public long getSnwNotifyId() throws Exception {
				JSONObject jsonObject = shardManager.getObjectId(new QueryObjectIdBuilder().setObject(SnwObjectType.NOTIFY.getValue(), 1));
				jsonObject = jsonObject.getJSONArray("object").getJSONObject(0);
				return Long.parseLong(jsonObject.getString("object"));
		}

		public void sendToTaskQueue(final Notify notify, final List params) throws Exception {
				taskQueueRepository.sentNotifyToTaskQueue(notify, params);
		}

		public void deleteNotify(final List<Long> ids, final List params) throws Exception {
				taskQueueRepository.sentDeleteNotifyToTaskQueue(ids, params);
		}

		public boolean insertNotifyMemcache(UserNotifications notifyData) throws Exception {
				return notifyCache.insertNotifyMemcache(notifyData);
		}

		public UserNotifications getNotifyMemcache(long userId) throws Exception {
				return notifyCache.getNotifyMemcache(userId);
		}

}
