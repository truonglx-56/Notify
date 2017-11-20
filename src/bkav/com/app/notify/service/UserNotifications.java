package bkav.com.app.notify.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by truonglx on 13/10/2017.
 */
public interface UserNotifications extends Serializable {
		long getUserId();

		List<NotifyDataResponse> getListNotify();

		void addNotify(NotifyDataResponse notifyDataResponse);
}
