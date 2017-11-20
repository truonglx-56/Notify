package bkav.com.app.notify.filter;

import bkav.com.app.notify.impl.NotifyDataImpl;
import bkav.com.app.notify.service.NotifyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx on 11/10/2017.
 */
public class FilterChain {
		private List<Filter> filterList;
		private Target target;

		public FilterChain() {
				filterList = new ArrayList<>();
		}

		public void addFilter(Filter filter) {
				filterList.add(filter);
		}

		public void execute(NotifyData notifyData) {
				for (Filter filter : filterList) {
						filter.execute(notifyData);
				}
				target.execute(notifyData);
		}

		public void setTarget(Target target) {
				this.target = target;
		}

}
