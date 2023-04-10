package portal.utils.suppliers;

import portal.requests.ListApiRequests;

public interface ApiRequestsSupplier {

    default ListApiRequests listApi() {
        return new ListApiRequests();
    }
}
