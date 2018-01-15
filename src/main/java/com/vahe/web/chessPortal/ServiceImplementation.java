package com.vahe.web.chessPortal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceImplementation implements ProductService {

	private final Map<Long, Product> products;
	
	private final List<Product> popularProducts;
	
	public ServiceImplementation() {
		Map<Long, Product> map = new HashMap<>();
		map.put(1L, new Product(1L, "Club", "plastic", new BigDecimal("60.00"), 60, "A comfortable and very popular product for training and tournements.", "Club"));
		map.put(2L, new Product(2L, "Iceglass", "glass", new BigDecimal("70.00"), 42, "Ice style chess set with traditional figure shapes.", "Iceglass"));
		map.put(3L, new Product(3L, "Geo", "wood", new BigDecimal("100.00"), 65, "Modern Geometrical chess figures gives a unique taste of game.", "Geo"));
		map.put(4L, new Product(4L, "curved", "fiber", new BigDecimal("90.00"), 55, "All rounded pieces with nice look and feel.", "Curved"));
		map.put(5L, new Product(5L, "elegant", "wood", new BigDecimal("78.00"), 50, "Real elegant cut style chess set.", "Elegant"));
		products=Collections.unmodifiableMap(map);
		popularProducts = Collections.unmodifiableList(new ArrayList<>(products.values()));
	}
	
	@Override
	public List<Product> getPopularProducts() {
		return popularProducts;
	}

	@Override
	public Product getProduct(long id) {
		return products.get(id);
	}
}
