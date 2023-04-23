package com.charisma.payment.contradiction;
/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for generated Contradiction
 * @since 1.0.1
 */
public interface IContradiction {
    /**
     *
     * @param request is a param when we have contradiction in payment
     */
    void create(Contradiction request);

    /**
     *
     * @param reference this reference used for resolve the contradiction
     */
    void resolve(String reference);
}
