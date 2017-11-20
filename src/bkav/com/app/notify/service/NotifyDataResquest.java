package bkav.com.app.notify.service;

import java.io.Serializable;

/**
 * Created by truonglx on 25/10/2017.
 */
public interface NotifyDataResquest extends Serializable {
		/*
		* Đối tượng đã gửi hoặc nguồn thông báo
	  */
		long getFrom();

		/*
		* Thời gian tạo thông báo
		*/
		long getCreatedTime();

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
		* Đối tượng chủ đề của notifi
		*/
		String getObject();

		/*
		* Kiểu thông báo(comment,like,tag,...)
		 */
		String getType();

		/*
		* Chuyển thông báo thành định dạng json
		 */
		String toJson();

		/*
		* Thời gian hết hạn của thông báo
		 */
		long getExpire();
}
