import java.io.IOException;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Node;
import io.kubernetes.client.openapi.models.V1NodeList;
import io.kubernetes.client.proto.Meta.List;
import io.kubernetes.client.util.Config;

public class ListNodes {
  public static void main(String[] args) throws ApiException, IOException {
    // Set up the Kubernetes client
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    // List nodes
    CoreV1Api api = new CoreV1Api();
    V1NodeList nodeList = api.listNode(null, null, null, null, null, null, null, null, null, null);
    java.util.List<V1Node> nodes = nodeList.getItems();
    for (V1Node node : nodes) {
      System.out.println("Node: " + node.getMetadata().getName());
    }
  }
}

//Output//
/*
Node: aino-tejas
Node: desktop-a1
*/




