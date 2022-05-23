package com.alexooodev.springWebApp.repositories;

import com.alexooodev.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
