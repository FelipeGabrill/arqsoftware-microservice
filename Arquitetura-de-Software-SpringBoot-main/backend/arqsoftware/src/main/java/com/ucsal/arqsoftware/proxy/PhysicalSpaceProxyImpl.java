package com.ucsal.arqsoftware.proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ucsal.arqsoftware.response.PhysicalSpace;
import com.ucsal.arqsoftware.response.PhysicalSpaceType;

@Service
public class PhysicalSpaceProxyImpl implements PhysicalSpaceProxy {

    private static final String BASE_URL = "http://localhost:8100/physicalspaces";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Page<PhysicalSpace> getPhysicalSpace(Pageable pageable) {
        // Para simplificar, você pode configurar os parâmetros manualmente
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
            .queryParam("page", pageable.getPageNumber())
            .queryParam("size", pageable.getPageSize())
            .toUriString();
        return restTemplate.getForObject(url, Page.class);
    }

    @Override
    public PhysicalSpace getPhysicalSpaceById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, PhysicalSpace.class);
    }

    @Override
    public PhysicalSpace postPhysicalSpace(PhysicalSpace physicalSpace) {
        return restTemplate.postForObject(BASE_URL, physicalSpace, PhysicalSpace.class);
    }

    @Override
    public PhysicalSpace putPhysicalSpace(Long id, PhysicalSpace physicalSpace) {
        restTemplate.put(BASE_URL + "/" + id, physicalSpace);
        return physicalSpace; // Supondo que você retorne o mesmo objeto
    }

    @Override
    public Void deletePhysicalSpace(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
        return null;
    }

    @Override
    public Page<PhysicalSpace> getByType(PhysicalSpaceType type, Pageable pageable) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/type/" + type)
            .queryParam("page", pageable.getPageNumber())
            .queryParam("size", pageable.getPageSize())
            .toUriString();
        return restTemplate.getForObject(url, Page.class);
    }

    @Override
    public Page<PhysicalSpace> getByCapacity(Integer capacity, Pageable pageable) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/capacity/" + capacity)
            .queryParam("page", pageable.getPageNumber())
            .queryParam("size", pageable.getPageSize())
            .toUriString();
        return restTemplate.getForObject(url, Page.class);
    }

    @Override
    public Page<PhysicalSpace> getByName(String name, Pageable pageable) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/name/" + name)
            .queryParam("page", pageable.getPageNumber())
            .queryParam("size", pageable.getPageSize())
            .toUriString();
        return restTemplate.getForObject(url, Page.class);
    }

    @Override
    public Page<PhysicalSpace> getByAvailability(Boolean availability, Pageable pageable) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/availability/" + availability)
            .queryParam("page", pageable.getPageNumber())
            .queryParam("size", pageable.getPageSize())
            .toUriString();
        return restTemplate.getForObject(url, Page.class);
    }
}
