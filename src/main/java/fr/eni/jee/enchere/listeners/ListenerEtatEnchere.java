package fr.eni.jee.enchere.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.eni.jee.enchere.dal.ConnectionProvider;

/**
 * Application Lifecycle Listener implementation class ListenerEtatEnchere
 *
 */
@WebListener
public class ListenerEtatEnchere implements ServletContextListener {

		private final static long TEMPS_ACTUALISATION = 5 * 60 * 1000; // 5 mn

		private Thread asyncTask = null;
		
		public ListenerEtatEnchere() {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
		 */
		public void contextDestroyed(ServletContextEvent sce) {
			System.out.println("application stoppée !");

			// a l'arret de l'application, arreter le processus
			if (asyncTask != null && asyncTask.isAlive()) {
				asyncTask.interrupt();
			}
		}

		/**
		 * @see ServletContextListener#contextInitialized(ServletContextEvent)
		 */
		public void contextInitialized(ServletContextEvent sce) {
			System.out.println("application demarrée !");
			// definir le processus //
			asyncTask = new Thread(new Runnable() {

				@Override
				public void run() {
					// définir le traitement
					try {
						cstmt = ConnectionProvider.getConnection().prepareCall(
								"[dbo].[updateArticle](?)"
								);
						while (!asyncTask.isInterrupted()) {
							System.out.println("Thread working every 5 mn");

							Thread.sleep(TEMPS_ACTUALISATION);
						}
					} catch (InterruptedException e) {
						System.out.println("Thread interrupted");
					}
				}
			});
			// lancer le processus
			asyncTask.start();
		}
	
}
