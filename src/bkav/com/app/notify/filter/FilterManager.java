package bkav.com.app.notify.filter;


/**
 * Created by truonglx on 11/10/2017.
 */
public class FilterManager {
		final private FilterChain filterChain;

		public FilterManager(Target target) {
				this.filterChain = new FilterChain();
				filterChain.setTarget(target);
		}

		public void addFilter(Filter filter) {
				filterChain.addFilter(filter);
		}

		public void filterRequest(Object data) throws Exception {
				filterChain.execute(data);
		}
}
