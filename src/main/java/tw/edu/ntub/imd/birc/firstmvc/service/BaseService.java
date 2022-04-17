package tw.edu.ntub.imd.birc.firstmvc.service;

public interface BaseService<B, ID> extends BaseViewService<B, ID> {
    @SuppressWarnings("UnusedReturnValue")
    B save(B b);

    void update(ID id, B b);

    void delete(ID id);


}
