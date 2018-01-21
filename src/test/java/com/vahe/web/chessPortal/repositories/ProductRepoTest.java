package com.vahe.web.chessPortal.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.vahe.web.chessPortal.javaBeans.Product;


@RunWith(Arquillian.class)
public class ProductRepoTest {

	@Inject
	private ProductRepo productRepo;

	@Test(expected=Exception.class)
	public void findInvalidId() {
		productRepo.find(null);
	}
	
	@Test(expected=Exception.class)
	public void createInvalidProduct() {
		Product pro = new Product(null, "plastic", new BigDecimal("60.00"), 60, "A comfortable and very popular product for training and tournements.", "Club");
		productRepo.create(pro);		
	}
	
	@Test
	public void create() throws Exception {
	assertEquals(Long.valueOf(0), productRepo.countAll());
	assertEquals(0, productRepo.findAll().size());
	
	//create new Chess set
	Product product = new Product("Club", "plastic", new BigDecimal("60.00"), 60, "A comfortable and very popular product for training and tournements.", "Club");
	product = productRepo.create(product);
	Long productId = product.getId();
	
	//Check created chess set
	assertNotNull(productId);
	
	//find created chess set
	Product productFound = productRepo.find(productId);
	
	//check the found book
	assertEquals("Club", productFound.getName());
	
	assertEquals(Long.valueOf(1), productRepo.countAll());
	assertEquals(1, productRepo.findAll().size());
	
	//Delete the chess set
	productRepo.Delete(productId);
	
	//check deletion
	assertEquals(Long.valueOf(0), productRepo.countAll());
	assertEquals(0, productRepo.findAll().size());
	
	}
	
	@Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class)
            .addClass(ProductRepo.class)
            .addClass(Product.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml");
    }
}
