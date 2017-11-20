package bkav.com.app.notify.service;


import com.bkav.snwcommon.json.JSONObject;

import java.io.Serializable;

/**
 * Created by truonglx on 06/10/2017.
 */
public interface NotifyData extends Serializable {

		/*
		* Id của notify object
		 */
		long getId();

		/*
		* Đối tượng đã gửi hoặc nguồn thông báo
		 */
		long getFrom();

		/*
		* Người nhận thông báo
		 */
		long getTo();

		/*
		* Thời gian tạo thông báo
		 */
		long getCreatedTime();

		/*
		* Thời gian cập nhật thông báo
		 */
		long updatedTime();

		/*
		* Nội dung hiển thị trong thông báo
		 */
		String getTitle();

		/*
		* Link tương tác khi click vào thông báo
		 */
		String getLink();

		/*
		* Ứng dụng tạo ra thông báo
		 */
		String getApp();

		/*
		* Trạng thái đã đọc hoặc chưa đọc của thông báo,nếu =0(đã đọc) thì không thể truy cap
		 */
		int getUnread();

		/*
		* Đối tượng chủ đề của notifi
		 */
		String getObject();


		/*
		* Set object for notify
		 */
		void setObject(String object);

		/*
		* Kiểu thông báo(comment,like,tag,...)
		 */
		String getType();

		/*
		* Chuyển thông báo thành định dạng json
		 */
		String toJson();

		/*
		* Phiên bản của thông báo
		 */
		int getVersion();

		/*
		* Thời gian hết hạn của thông báo
		 */
		long getExpire();
}
