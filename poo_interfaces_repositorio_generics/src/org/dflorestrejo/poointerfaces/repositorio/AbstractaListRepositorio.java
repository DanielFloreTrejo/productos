package org.dflorestrejo.poointerfaces.repositorio;

import org.dflorestrejo.poointerfaces.modelo.BaseEntity;
import org.dflorestrejo.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {

        if (id == 0 || id <= 0) {
            throw new LecturaAccesoDatoException("Id invalido, tiene que ser mayor que cero");
        }
        T resultado = null;

        for (T cli : this.dataSource) {
            if (cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        if (resultado == null) {
            throw new LecturaAccesoDatoException("No existe registros con el Id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if (t == null) {
            throw new EscrituraAccesoDatoException("Error al ingresar un registro null");
        }
        if (this.dataSource.contains(t)) {
            throw new EscrituraAccesoDatoException("Error el objeto con el id " + t.getId() + " ya existe");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return this.dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
