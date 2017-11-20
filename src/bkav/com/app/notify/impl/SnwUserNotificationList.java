package bkav.com.app.notify.impl;

import bkav.com.app.notify.service.NotifyDataResponse;
import bkav.com.app.notify.service.UserNotifications;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx on 13/10/2017.
 */
public class SnwUserNotificationList implements UserNotifications {
		private static final long serialVersionUID = 3372313514950323928L;

		private long userId;
		private List<NotifyDataResponse> notifyDataResponses;

		public SnwUserNotificationList(long userId, List<NotifyDataResponse> notifyDataResponses) {
				this.userId = userId;
				if (notifyDataResponses == null)
						this.notifyDataResponses = new ArrayList<>();
				else
						this.notifyDataResponses = notifyDataResponses;
		}

		@Override
		public long getUserId() {
				return userId;
		}

		@Override
		public List<NotifyDataResponse> getListNotify() {
				return notifyDataResponses;
		}

		@Override
		public void addNotify(NotifyDataResponse notifyDataResponse) {
				this.notifyDataResponses.add(0,notifyDataResponse);
		}

}
