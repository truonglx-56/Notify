package bkav.com.app.notify.impl;

import bkav.com.app.notify.service.NotifyDataResquest;
import com.bkav.snwcommon.json.JSONFactoryUtil;
import com.bkav.snwcommon.json.JSONObject;

/**
 * Created by truonglx on 31/10/2017.
 */
public class SnwNotifyDataRequest implements NotifyDataResquest {
		private long from;
		private long createdTime;
		private String title;
		private String link;
		private String app;
		private String object;
		private String type;
		private long expire;

		public SnwNotifyDataRequest(Builder builder) {
				this.from = builder.from;
				this.createdTime = builder.createdTime;
				this.title = builder.title;
				this.link = builder.link;
				this.app = builder.app;
				this.object = builder.object;
				this.type = builder.type;
				this.expire = builder.expire;
		}

		public static NotifyDataResquest create(JSONObject jsonObject) {
				return new Builder()
								.setObject(jsonObject.getString("object", ""))
								.setLink(jsonObject.getString("link", ""))
								.setTitle(jsonObject.getString("title", ""))
								.setExpire(jsonObject.getLong("expire", 0))
								.setCreatedTime(jsonObject.getLong("createdTime", 0))
								.setFrom(jsonObject.getLong("from",0))
								.setApp(jsonObject.getString("app", ""))
								.setType(jsonObject.getString("type", "")).build();
		}

		@Override
		public long getFrom() {
				return from;
		}

		@Override
		public long getCreatedTime() {
				return createdTime;
		}

		@Override
		public String getTitle() {
				return title;
		}

		@Override
		public String getLink() {
				return link;
		}

		@Override
		public String getApp() {
				return app;
		}

		@Override
		public String getObject() {
				return object;
		}

		@Override
		public String getType() {
				return type;
		}

		@Override
		public long getExpire() {
				return expire;
		}

		@Override
		public String toJson() {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("from", from);
				jsonObject.put("createdTime", createdTime);
				jsonObject.put("title", title);
				jsonObject.put("app", app);
				jsonObject.put("link", link);
				jsonObject.put("object", object);
				jsonObject.put("type", type);
				jsonObject.put("expire", expire);

				return jsonObject.toString();
		}

		public static class Builder {
				private long from;
				private long createdTime;
				private String title;
				private String link;
				private String app;
				private String object;
				private String type;
				private long expire;


				public Builder setFrom(long from) {
						this.from = from;
						return this;
				}

				public Builder setCreatedTime(long createdTime) {
						this.createdTime = createdTime;
						return this;
				}

				public Builder setTitle(String title) {
						this.title = title;
						return this;
				}

				public Builder setLink(String link) {
						this.link = link;
						return this;
				}

				public Builder setApp(String app) {
						this.app = app;
						return this;
				}

				public Builder setObject(String object) {
						this.object = object;
						return this;
				}

				public Builder setType(String type) {
						this.type = type;
						return this;
				}

				public Builder setExpire(long expire) {
						this.expire = expire;
						return this;
				}

				public NotifyDataResquest build() {
						return new SnwNotifyDataRequest(this);
				}
		}
}
