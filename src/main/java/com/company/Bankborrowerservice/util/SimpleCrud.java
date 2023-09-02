package com.company.Bankborrowerservice.util;

import com.company.Bankborrowerservice.dto.ResponseDto;

public interface SimpleCrud<K,V> {

    ResponseDto<V> create(V dto);
    ResponseDto<V> get(K id);
    ResponseDto<V> update(K id,V dto);
    ResponseDto<V> delete(K id);

}
