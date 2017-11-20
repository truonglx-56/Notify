package bkav.com.app.notify.filter;

import bkav.com.app.notify.service.NotifyData;

/**
 * Created by truonglx on 11/10/2017.
 */
public interface Filter {
		void execute(NotifyData notifyData);
}
