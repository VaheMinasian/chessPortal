package com.vahe.web.chessPortal.repositories;

import static org.junit.Assert.*; 

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
	
	@Test
	public void create() throws Exception {
		assertEquals(Long.valueOf(0), productRepo.countAll());
		assertEquals(0, productRepo.findAll().size());
	}
	
	@Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class)
            .addClass(ProductRepo.class)
            .addClass(Product.class)
            .addAsManifestResource("META-INF/test-persistence.xml", "beans.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
