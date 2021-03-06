package de.measite.contactmerger.contacts;

import android.provider.ContactsContract.CommonDataKinds.Im;

/**
 * ImMetadata represents an instant messaging metadata. This metadata is used
 * to show the online/offline status in the contacts app, as well as additional
 * information in the contact detail view.
 */
public class ImMetadata extends Metadata {

    /**
     * The IM Metadata string. Equivalent to {@link Im#CONTENT_ITEM_TYPE} 
     */
    public static final String MIMETYPE = Im.CONTENT_ITEM_TYPE;

    /**
     * The contact type class for instant messaging metadata blocks.
     */
    public static enum Type {

        /**
         * Custom instant messaging type.
         */
        CUSTOM(Im.TYPE_CUSTOM),

        /**
         * Home contact.
         */
        HOME(Im.TYPE_HOME),

        /**
         * Work contact.
         */
        WORK(Im.TYPE_WORK),

        /**
         * Other/Unknown/Unspecified contact type.
         */
        OTHER(Im.TYPE_OTHER);

        /**
         * The internal type value, as stored in the database.
         */
        private final int value;

        /**
         * Create a new type, wrapping a the given raw value.
         * @param value The database value for this type.
         */
        Type(int value) {
            this.value = value;
        }

        /**
         * Retrieve a type instalce for a given database value, or null.
         * @param id The database value.
         * @return A corresponding Type instance, or null.
         */
        private static Type byTypeId(int id) {
            switch(id) {
            case Im.TYPE_CUSTOM: return CUSTOM;
            case Im.TYPE_HOME: return HOME;
            case Im.TYPE_OTHER: return OTHER;
            case Im.TYPE_WORK: return WORK;
            }
            return null;
        }

        /**
         * Retrieve the database value for this type.
         * @return The database value of this type.
         */
        public int getValue() {
            return value;
        }
    };

    /**
     * Protocol type for metadata blocks.
     */
    public static enum Protocol {

        /**
         * Custom instant messaging protocol.
         */
        CUSTOM(Im.PROTOCOL_CUSTOM),

        /**
         * AOL instant messaging protocol.
         */
        AIM(Im.PROTOCOL_AIM),

        /**
         * MSN instant messaging protocol.
         */
        MSN(Im.PROTOCOL_MSN),

        /**
         * Yahoo! instant messaging protocol.
         */
        YAHOO(Im.PROTOCOL_YAHOO),

        /**
         * Skype instant messaging protocol.
         */
        SKYPE(Im.PROTOCOL_SKYPE),

        /**
         * QQ instant messaging protocol.
         */
        QQ(Im.PROTOCOL_QQ),

        /**
         * Google Talk instant messaging protocol.
         */
        GOOGLE_TALK(Im.PROTOCOL_GOOGLE_TALK),

        /**
         * ICQ instant messaging protocol.
         */
        ICQ(Im.PROTOCOL_ICQ),

        /**
         * Jabber instant messaging protocol.
         */
        JABBER(Im.PROTOCOL_JABBER),

        /**
         * Netmeeting instant messaging protocol.
         */
        NETMEETING(Im.PROTOCOL_NETMEETING);

        /**
         * The internal type value, as stored in the database.
         */
        private final int value;

        /**
         * Create a new type, wrapping a the given raw value.
         * @param value The database value for this type.
         */
        Protocol(int value) {
            this.value = value;
        }

        /**
         * Retrieve the Protocol instance for a given raw database value.
         * @param id The raw database value.
         * @return The corresponding Protocol instance, or null.
         */
        public static Protocol byProtocolId(int id) {
            switch(id) {
            case Im.PROTOCOL_CUSTOM: return CUSTOM;
            case Im.PROTOCOL_AIM: return AIM;
            case Im.PROTOCOL_MSN: return MSN;
            case Im.PROTOCOL_YAHOO: return YAHOO;
            case Im.PROTOCOL_SKYPE: return SKYPE;
            case Im.PROTOCOL_QQ: return QQ;
            case Im.PROTOCOL_GOOGLE_TALK: return GOOGLE_TALK;
            case Im.PROTOCOL_ICQ: return ICQ;
            case Im.PROTOCOL_JABBER: return JABBER;
            case Im.PROTOCOL_NETMEETING: return NETMEETING;
            }
            return null;
        }

        /**
         * Retrieve the raw database value for this protocol type.
         * @return The raw database value.
         */
        public int getValue() {
            return value;
        }
    };

    /**
     * Create a new instant messaging metadata type.
     */
    public ImMetadata() {
        mimetype = MIMETYPE;
    }

    /**
     * Change the type of this instant messaging metadata.
     * @param type The new instant messaging type.
     */
    public void setType(Type type) {
        setData(1, Integer.toString(type.getValue()));
    }

    /**
     * Retrieve the instant messaging contact type.
     * @return The current instant messaging contact type.
     */
    public Type getType() {
        try {
            return Type.byTypeId(Integer.parseInt(getData(1)));
        } catch (Exception e) {
            return Type.OTHER;
        }
    }

    /**
     * Change the label of the custom instant messaging type.
     * @param label The label of the custom instant messaging type.
     */
    public void setCustomTypeLabel(String label) {
        setData(2, label);
    }

    /**
     * Retrieve the custom instant messaging type label.
     * @return The custom instant messaging type label.
     */
    public String getCustomTypeLabel() {
        return getData(2);
    }

    /**
     * Change the protocol type.
     * @param protocol The new protocol type.
     */
    public void setProtocol(Protocol protocol) {
        setData(4, Integer.toString(protocol.getValue()));
    }

    /**
     * Retrieve the current protocol type.
     * @return The current protocol type.
     */
    public Protocol getProtocol() {
        try {
            return Protocol.byProtocolId(Integer.parseInt(getData(4)));
        } catch (Exception e) {
            return Protocol.CUSTOM;
        }
    }

    /**
     * Change the label of the custom protocol type.
     * @param label The new custom protocol label.
     */
    public void setCustomProtocolLabel(String label) {
        setData(5, label);
    }

    /**
     * Retrieve the current custom protocol label.
     * @return The custom protocol label.
     */
    public String getCustomProtocolLabel() {
        return getData(5);
    }

    /**
     * Throws {@link UnsupportedOperationException}.
     * @param mimetype Ignored.
     */
    @Override
    public void setMimetype(String mimetype) {
        throw new UnsupportedOperationException("Mimetype of Im is " + MIMETYPE);
    }

}
