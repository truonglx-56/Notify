package bkav.com.app.notify.service;

import bkav.com.app.notify.define.TypeNotify;

/**
 * Created by truonglx on 11/10/2017.
 */
public interface Notify {
		TypeNotify getType();   //Type dang go, tu app hoac theo action

		NotifyDataResquest getNotifyDataResquest();

		void setNotifyDataResquest(NotifyDataResquest data);
}
