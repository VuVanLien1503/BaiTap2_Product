package manager.service.my_impl;

import manager.model.Category;
import manager.repository.ICategoryRepository;
import manager.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }
}
