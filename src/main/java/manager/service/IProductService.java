package manager.service;

import manager.model.Product;
import manager.service.my_interface.ICrud;
import manager.service.my_interface.ISearch;

public interface IProductService extends ICrud<Product>, ISearch<Product> {
}
