package bkav.com.app.notify.cache;

import bkav.com.app.notify.service.UserNotifications;
import com.bkav.snwcommon.cache.memcached.MemcachedUtil;

/**
 * Created by truonglx on 13/10/2017.
 */
public class NotifyCache {

		public NotifyCache() {
		}

		private String getKey(long objId) {
				return "notify_" + String.valueOf(objId);
		}

		public boolean insertNotifyMemcache(final UserNotifications notifyData) throws Exception {
				return MemcachedUtil.getInstance().getMemCachedClient(memcachedClient ->
				{
						memcachedClient.set(getKey(notifyData.getUserId()), 0, notifyData);
						return memcachedClient.set(getKey(notifyData.getUserId()), 0, notifyData).get();
				});
		}

		public UserNotifications getNotifyMemcache(long userId) throws Exception {
				return MemcachedUtil.getInstance().getMemCachedClient(memcachedClient ->
								(UserNotifications) memcachedClient.get(getKey(userId))
				);
		}
}
