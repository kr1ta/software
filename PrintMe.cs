using System;

namespace PhotoOrderSystem
{
    public class PrintMe
    {
        private bool _serverStatus;
        private Order _order;

        public bool ServerStatus
        {
            get { return _serverStatus; }
            set { _serverStatus = value; }
        }

        public Order Order
        {
            get { return _order; }
            set { _order = value; }
        }

        public virtual void AddOrder(Order order)
        {
            if (_serverStatus)
            {
                _order = order;
                Console.WriteLine($"Order with ID {_order.Id} has been added successfully.");
            }
            else
            {
                Console.WriteLine("Cannot add order. Server is not available.");
            }
        }

        public virtual void SendOrder()
        {
            Console.WriteLine("Заказ отправлен!");
        }

        public virtual void ShowID()
        {
            Console.WriteLine($"Order ID: {_order.Id}");
        }

        public virtual void CheckServerStatus()
        {
            if (_serverStatus)
            {
                Console.WriteLine("Server is temporarily unavailable, sorry.");
            }
            else
            {
                Console.WriteLine("Server is OK! Continue operation.");
            }
        }

        public virtual void RequestMoney()
        {
            Console.WriteLine("Give us money please");
        }

        public virtual void AddPhoto()
        {
            throw new NotImplementedException();
        }

        public virtual void OpenOrder()
        {
            Order.EditorSettings.ShowFinalOrder();
            Console.WriteLine($"Order ID: {_order.Id}");
        }
    }
}