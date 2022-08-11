/* VenueAddressServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.VenueAddress;
import za.ac.cput.repository.VenueAddressRepository;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VenueAddressServiceImpl implements VenueAddressService {
    private VenueAddressRepository repository;

    @Autowired
    VenueAddressServiceImpl(VenueAddressRepository repository) {
        this.repository = repository;}

    @Override
    public VenueAddress save(VenueAddress venueAddress) {
        return this.repository.save(venueAddress);}

    @Override
    public VenueAddress read(String id) {
        return this.repository.findById(id).orElse(null);}

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<VenueAddress> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
