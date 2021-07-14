package ca.elecsoft.util;

import ca.elecsoft.model.version.twozerothreeE.ProdCadAVersionE;
import ca.elecsoft.model.version.twozerothreeE.ProdCadEVersionE;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * This class is for access product catalogue database
 */
public class HibernateUtilVersionE {
    public static HibernateUtilVersionE INSTANCE;
    Session session;
    SessionFactory factory;

    private HibernateUtilVersionE() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
    }

    public static HibernateUtilVersionE getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new HibernateUtilVersionE();
        }
        return INSTANCE;
    }

    public static ProdCadAVersionE buildProdCadA(String split, ProdCadAVersionE a) {
        String[] b = split.split("\\|");
        int i = 0;
        a.setProductid(b[i++]);
        a.setSbnproductcode(b[i++]);
        a.setName_en_(b[i++]);
        a.setName_fr_(b[i++]);
        a.setParent(b[i++]);
        a.setDescription(b[i++]);
        a.setDescription_fr_(b[i++]);
        a.setTechnicaldescription(b[i++]);
        a.setTechnicaldescription_fr_(b[i++]);
        a.setPanelid(b[i++]);
        a.setUpccode(b[i++]);
        a.setFieldserviceproducttype(b[i++]);
        a.setAddtocustomerasset_service_(b[i++]);
        a.setProductstructure(b[i++]);
        a.setProductcategory(b[i++]);
        a.setRevenuetype(b[i++]);
        a.setValidfrom(b[i++]);
        a.setValidto(b[i++]);
        a.setConverttocustomerasset(b[i++]);
        a.setCustomerprovidedequipment(b[i++]);
        a.setIndoor_outdoor(b[i++]);
        a.setUpc_scanningrequired(b[i++]);
        a.setSerializedproduct(b[i++]);
        a.setDecimalssupported(b[i++]);
        a.setDefaultpricelist(b[i++]);
        a.setDefaultunit(b[i++]);
        a.setLegacyitem(b[i++]);
        a.setStatus(b[i++]);
        a.setStatusreason(b[i++]);
        a.setUnitgroup(b[i++]);
        a.setSagedepletioncode(b[i++]);
        a.setSagereturncode(b[i++]);
        a.setBrc(b[i++]);
        a.setComponent(b[i++]);
        a.setDatecontrolledpromotion(b[i++]);
        a.setPromotionlength_months_(b[i++]);
        a.setExpirationdetailsrequired(b[i++]);
        a.setShelflife_month_(b[i++]);
        a.setPromotion_offertype(b[i++]);
        a.setMailout(b[i++]);
        a.setCurrency(b[i++]);
        a.setMedicalitem(b[i++]);
        a.setDummyproduct(b[i++]);
        a.setProcessid(b[i++]);
        a.setSensor(b[i++]);
        a.setActivatestackingfunctionality(b[i++]);
        a.setStackinggroup(b[i++]);
        a.setBundlespecification(b[i++]);
        a.setBundletype(b[i++]);
        a.setSelfinstall(b[i++]);
        a.setBundletier(b[i++]);
        a.setDateControlledService(b[i++]);


        return a;
    }

    public static ProdCadEVersionE buildProdCad(String split, ProdCadEVersionE a) {
        String[] b = split.split("\\|");
        int i = 0;
        a.setProductid(b[i++]);
        a.setSbnid(b[i++]);
        a.setName(b[i++]);
        a.setName_fr_(b[i++]);
        a.setParentproductid(b[i++]);
        a.setDescription(b[i++]);
        a.setDescription_fr_(b[i++]);
        a.setTechnicaldescription(b[i++]);
        a.setTechnicaldescription_fr_(b[i++]);
        a.setPanelid(b[i++]);
        a.setUpccode(b[i++]);
        a.setFieldserviceproducttype(b[i++]);
        a.setAddtocustomerasset(b[i++]);
        a.setProductstructure(b[i++]);
        a.setProductcategory(b[i++]);
        a.setRevenuetype(b[i++]);
        a.setValidfrom(b[i++]);
        a.setValidto(b[i++]);
        a.setConverttocustomerasset(b[i++]);
        a.setCpe(b[i++]);
        a.setIndoor_outdoor(b[i++]);
        a.setUpclookup(b[i++]);
        a.setSerializedproduct(b[i++]);
        a.setDecimalssupported(b[i++]);
        a.setDefaultpricelist(b[i++]);
        a.setDefaultunit(b[i++]);
        a.setLegacyitem(b[i++]);
        a.setStatus(b[i++]);
        a.setStatusreason(b[i++]);
        a.setUnitgroup(b[i++]);
        a.setSagedepletioncode(b[i++]);
        a.setSagereturncode(b[i++]);
        a.setBrc(b[i++]);
        a.setSbncomponentflag(b[i++]);
        a.setDatecontrolledpromo(b[i++]);
        a.setPromotionlength(b[i++]);
        a.setLifesafeyflag(b[i++]);
        a.setLifesafetylength(b[i++]);
        a.setPromotion_offertype(b[i++]);
        a.setMailout_y_n_(b[i++]);
        a.setLegacy_y_n_(b[i++]);
        a.setMedicalitem_y_n_(b[i++]);
        a.setDummybundle(b[i++]);
        a.setSbnproductid_forpackages_(b[i++]);
        a.setLegacysensors(b[i++]);
        a.setActivatestacking(b[i++]);
        a.setStackinggroup(b[i++]);
        a.setBundlespecification(b[i++]);
        a.setBundletype(b[i++]);
        a.setSelfinstalleligible(b[i++]);
        a.setBundletier(b[i++]);
        a.setDateControlledService(b[i++]);
        return a;
    }

    public void close() {
        factory.close();
        session.close();
    }



    public void dropTableProdCadA() {
        session.beginTransaction();
        session.createQuery("delete ProdCadA").executeUpdate();
        session.getTransaction().commit();
    }

    /**
     * @return This is returning every row/product in the expected product catalogue file
     */
    public List<ProdCadEVersionE> displayAllProdCadE() {
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<ProdCadEVersionE> list = (List<ProdCadEVersionE>) session.createQuery(
                "FROM ProdCadEVersionE").getResultList();
//        System.out.println(list);
        list.remove(0);
        t.commit();
        try {
            return list;

        } catch (Exception e) {
            return null;
        }
    }

    public ProdCadAVersionE getOneProdCadA(String productCode) {
//        Transaction t = session.beginTransaction();
        List<ProdCadAVersionE> list = (List<ProdCadAVersionE>) session.createQuery(
                "FROM ProdCadAVersionE where Productid = '" + productCode + "'").getResultList();
//        factory.close();
//        session.close();
//        t.commit();
        try {
            System.out.println(list);
            return list.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public ProdCadAVersionE displayOneProdCadA(String productCode) {
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        List<ProdCadAVersionE> list = (List<ProdCadAVersionE>) session.createQuery(
                "FROM ProdCadA where Productid = '" + productCode + "'").getResultList();
//        System.out.println(list);
        session.close();
        factory.close();
        try {
            return list.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public ProdCadEVersionE getOneProdCadE(String productCode) {
        Transaction t = session.beginTransaction();
        ProdCadEVersionE e = session.get(ProdCadEVersionE.class, productCode);
        t.commit();
        return e;
    }

    public ProdCadEVersionE displayOneProdCadE(String productCode) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        List<ProdCadEVersionE> list = (List<ProdCadEVersionE>) session.createQuery(
                "FROM ProdCadE where Productid = '" + productCode + "'").getResultList();
//        System.out.println(list);
        try {
            return list.get(0);

        } catch (Exception e) {
            return null;
        }
    }

    public void storeListProdCadE(String split, ProdCadEVersionE object) {
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.save(object);
        t.commit();
//        System.out.println("successfully saved");
//        factory.close();
//        session.close();

    }

    public void storeListProdCadA(String split, ProdCadAVersionE object) {
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.save(object);
        t.commit();
//        System.out.println("successfully saved");
//        factory.close();
//        session.close();

    }

    public void storeListGeneral(String split, ProdCadEVersionE object) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.save(object);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();

    }




}
