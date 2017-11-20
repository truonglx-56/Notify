package bkav.com.app.notify.filter;


import java.util.List;

/**
 * Created by truonglx on 11/10/2017.
 */
public interface Filter {
		List<Long> execute(final Object data) throws Exception;
}
