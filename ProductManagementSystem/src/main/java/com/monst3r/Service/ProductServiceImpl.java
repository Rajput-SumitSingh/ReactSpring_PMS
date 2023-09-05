package com.monst3r.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monst3r.Model.Product;
import com.monst3r.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return repository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> list = repository.findAll();
		return list;
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product product = repository.findById(id).get();
		if (product != null) {
			repository.delete(product);
			return "Product deleted successfully .....";
		}
		
		return "Something wrong on server side .... ";
	}

	@Override
	public Product editProduct(Product product, int id) {
		// TODO Auto-generated method stub
		Product oldProduct = repository.findById(id).get();
		oldProduct.setId(product.getId());
		oldProduct.setDescription(product.getDescription());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setProductName(product.getProductName());
		oldProduct.setStatus(product.getStatus());
		
		return repository.save(oldProduct);
	}
	
	

}
