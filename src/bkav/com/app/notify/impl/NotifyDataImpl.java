package bkav.com.app.notify.impl;

import bkav.com.app.notify.service.NotifyData;
import com.bkav.snwcommon.json.JSONFactoryUtil;
import com.bkav.snwcommon.json.JSONObject;

/**
 * @Tag: Example
 * Created by truonglx on 07/10/2017.
 */
public class NotifyDataImpl implements NotifyData {
		private static final long serialVersionUID = -124917918365459224L;

		private long id;
		private long from;
		private long to;
		private long createdTime;
		private long updatedTime;
		private String title;
		private String link;
		private String app;
		private int unread;
		private String object;
		private String type;
		private long expired;
		private int version;

		private NotifyDataImpl(Builder builder) {
				this.id = builder.id;
				this.from = builder.from;
				this.to = builder.to;
				this.createdTime = builder.createdTime;
				this.updatedTime = builder.updatedTime;
				this.title = builder.title;
				this.link = builder.link;
				this.app = builder.app;
				this.unread = builder.unread;
				this.object = builder.object;
				this.type = builder.type;
				this.expired = builder.expired;
				this.version = builder.version;
		}

		public long getId() {
				return id;
		}

		public long getFrom() {
				return from;
		}

		public long getTo() {
				return to;
		}

		public long getCreatedTime() {
				return createdTime;
		}

		public long updatedTime() {
				return updatedTime;
		}

		public String getTitle() {
				return title;
		}

		public String getLink() {
				return link;
		}

		public String getApp() {
				return app;
		}

		public int getUnread() {
				return unread;
		}

		public String getObject() {
				return object;
		}

		public void setObject(String object) {
				this.object = object;
		}

		public String getType() {
				return type;
		}

		public int getVersion() {
				return version;
		}

		public long getExpire() {
				return expired;
		}

		public String toJson() {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("id", id);
				jsonObject.put("from", from);
				jsonObject.put("to", to);
				jsonObject.put("createdTime", createdTime);
				jsonObject.put("updatedTime", updatedTime);
				jsonObject.put("title", title);
				jsonObject.put("link", link);
				jsonObject.put("app", app);
				jsonObject.put("unread", unread);
				if (object != null)
						jsonObject.put("object", object);
				jsonObject.put("type", type);

				return jsonObject.toString();
		}


		public static class Builder {
				private long id;
				private long from;
				private long to;
				private long createdTime;
				private long updatedTime;
				private String title;
				private String link;
				private String app;
				private int unread;
				private String object;
				private String type;
				private long expired;
				private int version;

				public Builder() {
				}

				public Builder setExpire(long expired) {
						this.expired = expired;
						return this;
				}

				public Builder setVersion(int version) {
						this.version = version;
						return this;
				}

				public Builder setId(long id) {
						this.id = id;
						return this;
				}

				public Builder setFrom(long from) {
						this.from = from;
						return this;

				}

				public Builder setTo(long to) {
						this.to = to;
						return this;

				}

				public Builder setCreatedTime(long createdTime) {
						this.createdTime = createdTime;
						return this;

				}

				public Builder setUpdatedTime(long updatedTime) {
						this.updatedTime = updatedTime;
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

				public Builder setUnread(int unread) {

						this.unread = unread;
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

				public NotifyData build() {
						return new NotifyDataImpl(this);
				}
		}
}
