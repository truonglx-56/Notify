package bkav.com.app.notify.filter;

import bkav.com.app.notify.service.NotifyData;

/**
 * Created by truonglx on 11/10/2017.
 */
public class FilterManager {
		private FilterChain filterChain;

		public FilterManager(Target target) {
				filterChain = new FilterChain();
				filterChain.setTarget(target);
		}

		public void addFilter(Filter filter) {
				filterChain.addFilter(filter);
		}

		public void filterRequest(NotifyData notifyData) {
				filterChain.execute(notifyData);
		}
}
