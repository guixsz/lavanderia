package com.lavanderia.api.services;

import com.lavanderia.api.dto.CreateRecord;
import com.lavanderia.api.entities.Applicant;
import com.lavanderia.api.entities.Provider;
import com.lavanderia.api.repositories.ProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProviderService {

    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Transactional
    public Provider createprovider(CreateRecord createRecord, Applicant applicant) {
        var provider = new Provider(
                createRecord.providerName(),
                createRecord.providerEmail(),
                createRecord.providerPhone(),
                createRecord.providerCnpj()
        );

        provider.setApplicant(applicant);

        return providerRepository.save(provider);
    }
}
