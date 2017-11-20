package bkav.com.app.notify.filter;

import java.util.List;

/**
 * Created by truonglx on 11/10/2017.
 */
public interface Target {
		void execute(Object data, List<Long> user) throws Exception;

}
