using System;

namespace PhotoOrderSystem
{
    public class Order
    {
        private int _id;
        private object _photo;
        private Editor _editorSettings;
        private payment _paymentStatus;

        public Order(int id, object photo, Editor editorSettings, payment paymentStatus)
        {
            _id = id;
            _photo = photo;
            _editorSettings = editorSettings;
            _paymentStatus = paymentStatus;
        }

        public enum payment
        {
            waiting_for_payment,
            paid,
            not_stated
        }

        public int Id
        {
            get { return _id; }
            set { _id = value; }
        }

        public object Photo
        {
            get { return _photo; }
            set { _photo = value; }
        }

        public Editor EditorSettings
        {
            get { return _editorSettings; }
            set { _editorSettings = value; }
        }

        public payment PaymentStatus
        {
            get { return _paymentStatus; }
            set { _paymentStatus = value; }
        }
    }
}
