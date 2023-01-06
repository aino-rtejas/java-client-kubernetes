import java.io.IOException;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1DeploymentList;
import io.kubernetes.client.proto.Meta.List;
import io.kubernetes.client.util.Config;

public class ListDeployments {
  public static void main(String[] args) throws ApiException, IOException {
    // Set up the Kubernetes client
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    // List Deployments
    AppsV1Api api = new AppsV1Api();
    V1DeploymentList deploymentList = api.listDeploymentForAllNamespaces(null, null, null, null, null, null, null, null, null, null);
    java.util.List<V1Deployment> deployments = deploymentList.getItems();
    for (V1Deployment deployment : deployments) {
      System.out.println("Deployment: " + deployment.getMetadata().getName());
    }
  }
}

/*
 * output *
Deployment: my-deployment
Deployment: calico-kube-controllers
Deployment: coredns
 */
 