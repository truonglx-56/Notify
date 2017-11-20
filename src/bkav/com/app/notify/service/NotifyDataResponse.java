package bkav.com.app.notify.service;


import com.bkav.snwcommon.json.JSONObject;

import java.io.Serializable;

/**
 * Created by truonglx on 06/10/2017.
 */
public interface NotifyDataResponse extends Serializable {

		/*
		* Id của notify object
		 */
		long getId();

		void setId(long id);

		/*
		* Đối tượng đã gửi hoặc nguồn thông báo,1 list cac nguoi gui(array json [])
		 */
		long[] getFrom();

		void setFrom(long[] from);

		/*
		* Người nhận thông báo
		 */
		long getTo();

		void setTo(long to);

		/*
		* Thời gian tạo thông báo
		 */
		long getCreatedTime();

		void setCreatedTime(long time);

		/*
		* Thời gian cập nhật thông báo
		 */
		long updatedTime();

		void setUpdateTime(long time);

		/*
		* Nội dung hiển thị trong thông báo
		 */
		String getTitle();

		void setTitle(String title);

		/*
		* Link tương tác khi click vào thông báo
		 */
		String getLink();

		void setLink(String link);

		/*
		* Ứng dụng tạo ra thông báo
		 */
		String getApp();

		void setApp(String app);

		/*
		* Trạng thái đã đọc hoặc chưa đọc của thông báo,nếu =0(đã đọc) thì không thể truy cap
		 */
		int getUnread();

		void setUnread(int unread);

		/*
		* Đối tượng chủ đề của notifi
		 */
		String getObject();

		void setObject(String object);

		/*
		* Kiểu thông báo(comment,like,tag,...)
		 */
		String getType();

		void setType(String type);

		/*
		* Chuyển thông báo thành định dạng json
		 */
		String toJson();

		/*
		* Phiên bản của thông báo
		 */
		int getVersion();

		void setVersion(int version);

		/*
		* Thời gian hết hạn của thông báo
		 */
		long getExpire();

		void setExpire(long expire);

		/*
		* Notify bi an hay khong(visiable -0: an, visiable =1: hien thi)
		 */
		int getVisiable();

		void setVisiable(int visiable);
}
