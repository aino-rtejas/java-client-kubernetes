import java.io.IOException;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.proto.V1.List;
import io.kubernetes.client.util.Config;

public class ListPods {
  public static void main(String[] args) throws ApiException, IOException {
    // Set up the Kubernetes client
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    // List pods
    CoreV1Api api = new CoreV1Api();
    V1PodList podList = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null, null);
    java.util.List<V1Pod> pods = podList.getItems();
    for (V1Pod pod : pods) {
      System.out.println("Pod: " + pod.getMetadata().getName());
    }
  }
}

/*
 Output 
 Pod: my-deployment-55946b8c4f-7k8kf
Pod: my-deployment-55946b8c4f-qrv8z
Pod: my-deployment-55946b8c4f-zp2rh
Pod: test-pod-apache2
Pod: calico-kube-controllers-7b8458594b-jnmx7
Pod: calico-node-h6nwl
Pod: calico-node-m85ng
Pod: coredns-64897985d-c2rf2
Pod: coredns-64897985d-kqbgv
Pod: etcd-aino-tejas
Pod: kube-apiserver-aino-tejas
Pod: kube-controller-manager-aino-tejas
Pod: kube-proxy-fp5sl
Pod: kube-proxy-znf98
Pod: kube-scheduler-aino-tejas
 */
 