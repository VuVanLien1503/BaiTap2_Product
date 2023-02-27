package manager.service;

import manager.model.Category;
import manager.service.my_interface.ICrud;
import manager.service.my_interface.ISearch;

public interface ICategoryService extends ICrud<Category>, ISearch<Category> {
}
